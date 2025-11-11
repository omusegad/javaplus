package com.commerce.salesapp.mapper;

import com.commerce.salesapp.dto.TaskRequest;
import com.commerce.salesapp.dto.TaskResponse;
import com.commerce.salesapp.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponse toDto(Task task);
    Task toEntity(TaskRequest taskRequest);
    List<TaskResponse> toDtoList(List<Task> task);

}