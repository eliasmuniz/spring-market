package com.test.market.persistence.mapper;

import com.test.market.domain.Category;
import com.test.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // diseñamos los mappers
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")

    })
    Category toCategory(Categoria categoria);

    // Conversión externa
    // indica a mapstruc que la conversión que hacemos acá es la inversa
    @InheritInverseConfiguration
    @Mapping(target= "productos", ignore = true)
    Categoria toCategoria(Category category);
}
