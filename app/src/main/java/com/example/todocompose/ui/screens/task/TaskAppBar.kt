package com.example.todocompose.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todocompose.R
import com.example.todocompose.util.Action

@Composable
fun TaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(
        onClick = {
            onBackClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_arrow),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(
        onClick = {
            onAddClicked(Action.ADD)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_task),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
@Preview
fun NewTaskAppBarPreview() {
    NewTaskAppBar(
        navigateToListScreen = {}
    )
}