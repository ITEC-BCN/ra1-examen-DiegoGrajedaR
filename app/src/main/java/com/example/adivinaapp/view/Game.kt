package com.example.adivinaapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.adivinaapp.R
import com.example.adivinaapp.Routes
import kotlin.concurrent.timer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController) {

    var numUser by remember { mutableStateOf("Escriu un número") }
    var secretNum by remember { mutableStateOf("") }
    var listNums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var counter = 0
    var msgCorrect by remember { mutableStateOf("") }
    var msgAttempts by remember { mutableStateOf("") }
    var timer by remember { mutableStateOf(1f) }

    ConstraintLayout(modifier = Modifier.fillMaxSize())
    {

        val (boxProgressIndicator, boxTextField, boxButtComprove, boxButtonsOptions ) = createRefs()
        Box(modifier = Modifier.constrainAs(boxProgressIndicator)
        {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(boxTextField.top)
        })
        {
            Column(){
                Text("?",
                    modifier = Modifier.padding(15.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                LinearProgressIndicator(
                    progress = 0.5f,
                    Modifier.width(300.dp).height(10.dp),
                    color = Color.Red,

                    )
            }


        }

        Box(modifier = Modifier.padding(25.dp).constrainAs(boxTextField)
        {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(boxButtComprove.top)
        })
        {
            TextField(
                value = numUser,
                onValueChange =  {numUser = it},
                label = {Text("Introdueix un número (1-10)")}
            )
        }

        Box(modifier = Modifier.padding(25.dp).constrainAs(boxButtComprove)
        {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }) {
            Column() {
                Button(
                    onClick = {},
                )
                {
                    Text("Comprovar")
                }
                Text(msgCorrect)
                Text(msgAttempts)
            }

        }

        Box(modifier = Modifier.constrainAs(boxButtonsOptions)
        {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxButtComprove.bottom)
        })
        {   Row() {
            Button(
                modifier = Modifier.padding(5.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF246860),
                    contentColor = Color.White
                ),
            ) {
                Text(text = "Tornar a jugar")
            }

            Button(
                modifier = Modifier.padding(5.dp),
                onClick = { navController.navigate(Routes.MenuScreen.route)},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF537770),
                    contentColor = Color.White
                ),
            ) {
                Text(text = "Menú principal")
            }
        }

        }
    }
}

