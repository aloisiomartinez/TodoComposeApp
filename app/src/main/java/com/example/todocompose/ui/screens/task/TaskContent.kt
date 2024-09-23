package com.example.todocompose.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todocompose.R
import com.example.todocompose.components.PriorityDropDown
import com.example.todocompose.data.models.Priority
import com.example.todocompose.ui.theme.LARGE_PADDING
import com.example.todocompose.ui.theme.MEDIUM_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
    innerPadding: PaddingValues
) {
    Box(modifier = Modifier.padding(innerPadding)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(all = LARGE_PADDING)
        ) {
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor  = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedBorderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                ),
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { onTitleChange(it) },
                label = { Text(text = stringResource(id = R.string.title))},
                singleLine = true
            )
            HorizontalDivider(
                modifier = Modifier.height(MEDIUM_PADDING),
                color = MaterialTheme.colorScheme.background
            )
            PriorityDropDown(priority = priority, onPrioritySelected=onPrioritySelected)

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor  = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedTextColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    focusedBorderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                ),
                modifier = Modifier.fillMaxSize(),
                value = description,
                onValueChange = {onDescriptionChange(it)},
                label = { Text(text = stringResource(id = R.string.description))}
            )


        }
    }
}

@Composable
@Preview
private fun TaskContentPreview() {
    TaskContent(
        title = "Estudar",
        onTitleChange = {},
        description = "Estudar Android ToDoApp",
        onDescriptionChange = {} ,
        priority = Priority.LOW,
        onPrioritySelected = {},
        innerPadding = PaddingValues()
    )
}