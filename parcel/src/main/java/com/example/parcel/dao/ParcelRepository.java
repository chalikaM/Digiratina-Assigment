package com.example.parcel.dao;

import com.example.parcel.entity.Parcel;

import java.util.List;

public interface ParcelRepository {

    void saveParcel(Parcel parcel);

    List<Parcel> getAllParcels();
}
