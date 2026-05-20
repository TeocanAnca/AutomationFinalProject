package utils;

import dto.PetDto;
import dto.StoreOrderDto;
import dto.UserDto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestDataFactory {
    public static PetDto createPet(long id, String petName, PetDto.CategoryDto categoryName, PetDto.TagDto petTag, String petStatus){
        PetDto petDto = new PetDto();
        petDto.setId(id);
        petDto.setName(petName);
        petDto.setCategory(categoryName);
        petDto.setTags(Collections.singletonList(petTag));
        petDto.setStatus(petStatus);
        petDto.setPhotoUrls(Collections.emptyList());
        return petDto;
    }

    public static StoreOrderDto createdStoreOrder (long id, long petId, int quantity, String shipDate, String status, boolean complete){
        StoreOrderDto storeOrderDto = new StoreOrderDto();
        storeOrderDto.setId(id);
        storeOrderDto.setPetId(petId);
        storeOrderDto.setQuantity(quantity);
        storeOrderDto.setShipDate(shipDate);
        storeOrderDto.setStatus(status);
        storeOrderDto.setComplete(complete);
        return storeOrderDto;
    }

    public static UserDto createUser (long id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus)
    {
        UserDto userDtoObject = new UserDto();
        userDtoObject.setId(id);
        userDtoObject.setUsername(username);
        userDtoObject.setFirstName(firstName);
        userDtoObject.setLastName(lastName);
        userDtoObject.setEmail(email);
        userDtoObject.setPassword(password);
        userDtoObject.setPhone(phone);
        userDtoObject.setUserStatus(userStatus);
        return userDtoObject;
    }
}
