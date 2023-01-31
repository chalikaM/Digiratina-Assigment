package com.example.parcel.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parcel {

    private long id;

    private String senderName;

    private String receiverName;

    private long companyId;

    private long locationId;

}
