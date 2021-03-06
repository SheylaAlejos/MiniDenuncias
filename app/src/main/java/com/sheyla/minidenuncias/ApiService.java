package com.sheyla.minidenuncias;

import com.sheyla.minidenuncias.Model.Denuncias;
import com.sheyla.minidenuncias.Model.Usuarios;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Sheyla on 25/05/2018.
 */

public interface ApiService {

     String API_BASE_URL = "https://lab-android-sheyla-alejos.c9users.io";

    @GET("api/v1/usuarios/{id}")
    Call<Usuarios> showUser(@Path("id") Integer id);

    @FormUrlEncoded
    @POST("/api/v1/login")
    Call<Usuarios> login(@Field("username") String username,
                         @Field("password") String password);
    @GET("api/v1/denuncias")
    Call<List<Denuncias>> getDenuncias();

    @GET("api/v1/usuarios")
    Call<List<Usuarios>> getUsuarios();


    @FormUrlEncoded
    @POST("api/v1/usuarios")
    Call<ResponseMessage> createUsuarios(@Field("nombre") String nombre,
                                         @Field("apellido") String apellido,
                                         @Field("username") String username,
                                         @Field("password") String password,
                                         @Field("distrito") String distrito,
                                         @Field("tipo") int tipo );


    @FormUrlEncoded
    @POST("api/v1/denuncias")
    Call<ResponseMessage> createDenuncias(
            @Field("id_user") Integer id_user,

            @Field("titulo") String titulo,
            @Field("descripcion") String descripcion,
            @Field("ubicacion") String ubicacion);

    @Multipart
    @POST("api/v1/denuncias ")
    Call<ResponseMessage> createDenunciaWhithImage(
            @Part("id_user") RequestBody id_user,

            @Part("titulo") RequestBody nombre,
            @Part("descripcion") RequestBody apellido,
            @Part("ubicacion") RequestBody username,
            @Part MultipartBody.Part pfoto

    );
    @GET("api/v1/denuncias/{id_user}")
    Call<List<Denuncias>> DenunciasPropias(@Path("id_user") Integer id_user);


}
