package com.pi.gest.dto;

import com.pi.gest.model.Address;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDto {

    private String addressOne;
    private String addressTwo;
    private String ville;
    private String codePostale;
    private String pays;


    public  static AddressDto fromEntity(Address address) {
        if (address == null) {
            return null;
        }
        return AddressDto.builder()
                .addressOne(address.getAddressOne())
                .addressTwo(address.getAddressTwo())
                .codePostale(address.getCodePostale())
                .ville(address.getVille())
                .pays(address.getPays())
                .build();
    }
    public static Address toEntity(AddressDto addressDto){

        if (addressDto == null) { return null; }
        Address address = new Address();
        address.setAddressOne(addressDto.getAddressOne());
        address.setAddressTwo(addressDto.getAddressTwo());
        address.setCodePostale(addressDto.getCodePostale());
        address.setPays(addressDto.getPays());
        address.setVille(addressDto.getVille());

    return address;
    }
}
