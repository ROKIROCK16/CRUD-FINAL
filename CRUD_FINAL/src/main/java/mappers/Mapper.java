package mappers;

import dto.AnimalesRegsitroDTO;
import dto.DireccionRegistroDTO;
import dto.UsuarioConsultaDTO;
import dto.UsuarioRegistroDTO;
import models.AnimalesEntity;
import models.DireccionEntity;
import models.RazaEntity;
import models.UsuarioEntity;

import java.time.LocalDate;
import java.time.Period;

public class Mapper {

    public static UsuarioEntity toUsuarioEntity(UsuarioRegistroDTO usuarioRegistroDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioRegistroDTO.nombre(), usuarioRegistroDTO.apellidoPaterno(),
                usuarioRegistroDTO.apellidoMaterno(), usuarioRegistroDTO.fechaNacimiento());
        usuarioEntity.setDireccionEntity(toDireccionEntity(usuarioRegistroDTO.direccionRegistroDTO()));
        return usuarioEntity;
    }
    public static UsuarioRegistroDTO toUsuarioRegistroDTO(UsuarioEntity usuarioEntity) {
        return new UsuarioRegistroDTO(usuarioEntity.getNombre(), usuarioEntity.getApellidoP(),
                usuarioEntity.getApellidoM(), usuarioEntity.getCorreoE(), usuarioEntity.getFechaNacimiento(), usuarioEntity.getCurp(),
                usuarioEntity.getNumeroTel(), usuarioEntity.getContrasena(),
                toDireccionRegistroDTO(usuarioEntity.getDireccionEntity()));
    }
    public static UsuarioConsultaDTO toUsuarioConsultaDTO(UsuarioEntity usuarioEntity) {
        String nombreCompleto = String.format("%s %s %s",
                usuarioEntity.getNombre(), usuarioEntity.getApellidoP(),
                usuarioEntity.getApellidoM());
        DireccionEntity direccionEntity = usuarioEntity.getDireccionEntity();
        String direccion = String.format("%s, %s, %s, %s, C.P. %d",
                direccionEntity.getCalle(), direccionEntity.getColonia(),
                direccionEntity.getMunicipio(), direccionEntity.getEstado(),
                direccionEntity.getCp());
        int edad = Period.between(usuarioEntity.getFechaNacimiento(), LocalDate.now()).getYears();
        return new UsuarioConsultaDTO(nombreCompleto, direccion, edad);
    }
    public static DireccionRegistroDTO toDireccionRegistroDTO(DireccionEntity direccionEntity) {
        return new DireccionRegistroDTO(direccionEntity.getCalle(),
                direccionEntity.getColonia(), direccionEntity.getCp(),
                direccionEntity.getMunicipio(), direccionEntity.getEstado());
    }
    public static DireccionEntity toDireccionEntity(DireccionRegistroDTO direccionRegistroDTO) {
        return new DireccionEntity(direccionRegistroDTO.calle(),
                direccionRegistroDTO.colonia(), direccionRegistroDTO.cp(),
                direccionRegistroDTO.municipio(), direccionRegistroDTO.estado());
    }

    public static RazaEntity toRazaEntity (){

    }

    public static AnimalesEntity toAnimalEntity (AnimalesRegsitroDTO animalesRegsitroDTO){
        AnimalesEntity animalesEntity = new AnimalesEntity(animalesRegsitroDTO.nombre(), animalesRegsitroDTO.sexo(),
                animalesRegsitroDTO.fechaNacimiento(), animalesRegsitroDTO.estado());
        animalesEntity.setRaza();
    }


}