package service;

import dto.AnimalesConsultaDTO;
import dto.AnimalesRegsitroDTO;
import mappers.Mapper;
import models.AnimalesEntity;
import repository.AnimalesRepository;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    private AnimalesRepository animalesRepository = new AnimalesRepository();

    public void registroAnimal(AnimalesRegsitroDTO animalesRegsitroDTO) throws Exception {
        if (animalesRegsitroDTO == null) {
            throw new Exception("Animal null");
        }

        animalesRepository.addAnimal(Mapper.toAnimalEntity(animalesRegsitroDTO));
    }

    public List<AnimalesConsultaDTO> obtenerAnimales(){
        List<AnimalesEntity> animalesEntityList = animalesRepository.getAllAnimales();
        List<AnimalesConsultaDTO> animalesDtos = new ArrayList<>();
        for (AnimalesEntity animalesEntity : animalesEntityList) {
            animalesDtos.add(Mapper.toAnimalesConsultaDTO(animalesEntity));
        }
        return animalesDtos;
    }
}
