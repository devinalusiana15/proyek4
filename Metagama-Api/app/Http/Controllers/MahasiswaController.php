<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Mahasiswa;

class MahasiswaController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $mahasiswa = Mahasiswa::all();

        return response()->json([
            'message' => 'Successfully retrieved mahasiswa',
            'data' => $mahasiswa,
        ]);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $validatedData = $request->validate([
            'nama' => 'required',
            'nim' => 'required|unique:mahasiswa',
            'jurusan' => 'required',
            'prodi' => 'required',
            'email' => 'required|email|unique:mahasiswa',
            'password' => 'required|min:8|confirmed'
        ]);

        $mahasiswa = Mahasiswa::create($validatedData);

        return response()->json([
            'message' => 'Mahasiswa created successfully',
            'data' => $mahasiswa,
        ]);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $mahasiswa = Mahasiswa::find($id);

        if (!$mahasiswa) {
            return response()->json([
                'message' => 'Mahasiswa not found',
            ], 404);
        }

        return response()->json([
            'message' => 'Successfully retrieved mahasiswa',
            'data' => $mahasiswa,
        ]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $mahasiswa = Mahasiswa::find($id);

        if (!$mahasiswa) {
            return response()->json([
                'message' => 'Mahasiswa not found',
            ], 404);
        }

        $validatedData = $request->validate([
            'nama' => 'string|max:255',
            'nim' => 'string|max:10|unique:mahasiswa,nim,' . $id,
            'jurusan' => 'string|max:255',
            'prodi' => 'string|max:255',
            'email' => 'string|max:255|unique:mahasiswa,email,' . $id,
            'password' => 'string|min:8|confirmed',
        ]);

        $mahasiswa->update($validatedData);

        return response()->json([
            'message' => 'Mahasiswa updated successfully',
            'data' => $mahasiswa,
        ]);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $mahasiswa = Mahasiswa::find($id);

        if (!$mahasiswa) {
            return response()->json([
                'message' => 'Mahasiswa not found',
            ], 404);
        }

        $mahasiswa->delete();

        return response()->json([
            'message' => 'Mahasiswa deleted successfully',
        ]);
    }
}
