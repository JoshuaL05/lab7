package com.example.lab7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UpcomingRacesScreen(navController: NavController){
    var location by remember { mutableStateOf("") }
    var races = remember { mutableListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ){
        Spacer(modifier = Modifier.height(16.dp))


        //back button
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton")
        ){
            Text(text = "Back")

        }

        Spacer(modifier = Modifier.height(16.dp))

        //title of screen
        Text(
            text = "Upcoming Races",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        //input field text
        Row(modifier = Modifier.fillMaxWidth()){
            TextField(
                value = location,
                onValueChange = {
                    location = it
                },
                label = {Text("Race Location")},
                modifier = Modifier.testTag("locationInput")
            )//end textField

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if(location.isNotBlank()){
                        races.add(location)
                        location = ""
                    }
                },
                modifier = Modifier.testTag("addRaceButton")
            ){
                Text("Add")

            }//end button
        }

        LazyColumn {
            items(races) { race ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }



    }//end col


}//end UpcomingRacesScreen