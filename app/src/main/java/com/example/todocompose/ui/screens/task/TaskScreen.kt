package com.example.todocompose.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.todocompose.data.models.Priority
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.util.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?, navigateToListScreen: (Action) -> Unit
) {
    Scaffold(topBar = {
        TaskAppBar(selectedTask = selectedTask, navigateToListScreen = navigateToListScreen)
    }, content = { innerPadding ->
        TaskContent(
            title = "Estudar",
            onTitleChange = {},
            description = "Estudar Android ToDoApp",
            onDescriptionChange = {} ,
            priority = Priority.LOW,
            onPrioritySelected = {},
            innerPadding
        )
    })
}