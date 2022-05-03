package com.pi.gest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pi.gest.model.Role;
import com.pi.gest.model.Utilisateur;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RoleDto {

    private Integer id;
    private String roleName;

    @JsonIgnore
    private UtilisateurDto user;

    public  static RoleDto fromEntity(Role role){
        if(role == null){
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .build();
    }
    public  static Role toEntity(RoleDto roleDto){
        if(roleDto==null){
            return null;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());
        role.setUser(UtilisateurDto.toEntity(roleDto.getUser()));

        return role;
    }
}


