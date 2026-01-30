package com.example.adivinaapp.view

import android.icu.text.ListFormatter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Span
import androidx.navigation.NavController
import com.example.adivinaapp.R
import com.example.adivinaapp.Routes
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun MenuScreen(navController: NavController) {

        ConstraintLayout(modifier = Modifier.fillMaxSize())
        {
            val (boxImg, boxText, boxButton) = createRefs()

            Box(modifier = Modifier.constrainAs(boxText)
            {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(boxImg.top)
            })
            {
                Text(text = "Adivina el número by Diego Grajeda",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                    )
            }
            Box(modifier = Modifier.padding(25.dp).constrainAs(boxImg)
            {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }) {
                Image(
                    painter = painterResource(R.drawable.ic_game),
                    contentDescription = "Image icon per al menuScreen"
                )
            }

            Box(modifier = Modifier.constrainAs(boxButton)
            {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(boxImg.bottom)
            })
            {
                Button(
                    onClick = { navController.navigate(Routes.GameScreen.route)},
                    Modifier.width(350.dp))
                {
                    Text("Iniciar partida")
                }
            }
        }



}