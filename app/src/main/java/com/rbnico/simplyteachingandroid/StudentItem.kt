package com.rbnico.simplyteachingandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun StudentItem(
    student: Student,
    click: (Student) -> Unit
) {
    val photoString = if (student.photo.length>2)
        remember {mutableStateOf(student.photo)}
    else remember {mutableStateOf("https://icon-library.com/images/generic-user-icon/generic-user-icon-19.jpg")}
    Card(
        elevation = 30.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                DataProvider.currentStudent = student
                click(student)
            }

    ) {
        Column (
            modifier = Modifier.padding(vertical = 10.dp)
                ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 20.dp)
            ) {
                Image(
                    painter = rememberImagePainter(photoString.value),
                    contentDescription = "Student photo",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = student.name + " " + student.lastName,
                    modifier = Modifier.padding(start = 20.dp),
                    fontWeight = FontWeight.Bold
                )
//                Text(
//                    text = ,
//                    modifier = Modifier.padding(start = 5.dp),
//                    fontWeight = FontWeight.Bold
//                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 20.dp)
            ) {
                Text(
                    text = "Curso: ",
                    fontWeight = FontWeight.Medium)
                Text(student.course.toString())
                Text(
                    text = "Edad: ",
                    fontWeight = FontWeight.Medium,
//                    modifier = Modifier.padding(start = 60.dp)
                )
                Text(student.age.toString())
            }
        }
    }

}