package service;

import dto.UsuarioConsultaDTO;
import dto.UsuarioRegistroDTO;
import mappers.Mapper;
import models.UsuarioEntity;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void registrarUsuario(UsuarioRegistroDTO usuarioRegistroDTO) throws Exception {
        if (usuarioRegistroDTO == null) {
            throw new Exception("UsuarioEntity null");
        }
        // mas validaciones
        usuarioRepository.addUser(Mapper.toUsuarioEntity(usuarioRegistroDTO));
    }

    public List<UsuarioConsultaDTO> obtenerUsuarios() {
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.getAllUsers();
        List<UsuarioConsultaDTO> usuariosDtos = new ArrayList<>();
        for (UsuarioEntity usuarioEntity : usuarioEntityList) {
            usuariosDtos.add(Mapper.toUsuarioConsultaDTO(usuarioEntity));
        }
//        List<UsuarioConsultaDTO> usuariosDtos = usuarioEntityList.stream()
//                        .map(Mapper::toUsuarioConsultaDTO)
//                        .toList();
        return usuariosDtos;
    }
    public void login(String correo, String contrasena) {
    }
}
