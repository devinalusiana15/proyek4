<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\Mahasiswa;

class AuthController extends Controller
{
    public function register(Request $request)
    {
        $request->validate([
            'nama' => 'required|string',
            'nim' => 'required|unique:mahasiswa|numeric',
            'jurusan' => 'required|string',
            'prodi' => 'required|string',
            'email' => 'required|unique:mahasiswa|email',
            'password' => 'required|string|confirmed',
        ]);

        $mahasiswa = Mahasiswa::create([
            'nama' => $request->nama,
            'nim' => $request->nim,
            'jurusan' => $request->jurusan,
            'prodi' => $request->prodi,
            'email' => $request->email,
            'password' => bcrypt($request->password),
        ]);

        return response()->json([
            'message' => 'Registrasi berhasil',
            'mahasiswa' => $mahasiswa,
        ], 201);
    }

    public function login(Request $request)
    {
        $request->validate([
            'nim' => 'required|numeric',
            'password' => 'required|string',
        ]);

        $credentials = $request->only('nim', 'password');

        if (Auth::attempt($credentials)) {
            $mahasiswa = Mahasiswa::where('nim', $request->nim)->first();
            $token = $mahasiswa->createToken('MahasiswaToken')->accessToken;

            return response()->json([
                'message' => 'Login berhasil',
                'mahasiswa' => $mahasiswa,
                'access_token' => $token,
            ], 200);
        }

        return response()->json([
            'message' => 'Login gagal, nim atau password salah',
        ], 401);
    }
}
