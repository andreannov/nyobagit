package com.example.roomreservation.api;

import com.example.roomreservation.db.models.Room;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.Call;

// ApiService Interface
public interface ApiService {

    // Base URL of the API
    String BASE_URL = "https://api.example.com/";

    // Retrofit Instance
    static ApiService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }

    // Get List of Rooms
    @GET("rooms")
    Call<List<Room>> getRooms(@Header("Authorization") String token);

    // Get Room Details by ID
    @GET("rooms/{id}")
    Call<Room> getRoomDetails(@Path("id") int roomId);

    @GET("rooms/{id}")
    Call<Room> getRoomDetails(@Header("Authorization") String token, @Path("id") int roomId);

    // Make a Reservation
    @POST("reservations")
    Call<ReservationResponse> makeReservation(@Body ReservationRequest request);

    // Confirm Reservation
    @POST("reservations/confirm")
    Call<ConfirmationResponse> confirmReservation(@Body ConfirmationRequest request);

    // Cancel Reservation
    @POST("reservations/cancel")
    Call<CancelResponse> cancelReservation(@Body CancelRequest request);

    @POST("reservations")
    Call<JSONObject> createReservation(
            @Header("Authorization") String token,
            @Body Reservation reservation
    );

    @POST("auth/login")
    Call<JSONObject> loginUser(@Field("email") String email, @Field("password") String password);
}

