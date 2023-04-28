package com.example.bmiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmiapp.ui.theme.BMIAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(20.dp)
                    ) {

                        /// タイトル
                        Text(
                            text = "BMI計算",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(20.dp)
                        )

                        /// 身長タイトル


                        /// TextField
                        TextField(
                            value = viewModel.height,
                            callBack = {
                                viewModel.height = it
                                       },
                            labelText = "身長(cm)",
                            placeholder = "170"
                        )

                        Spacer(modifier = Modifier.height(20.dp))


                        /// TextField
                        TextField(
                            value = viewModel.weight,
                            callBack = {
                                viewModel.weight = it
                                       },
                            labelText = "体重(kg)",
                            placeholder = "60"
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        /// 計算する
                        Button(
                            colors = ButtonDefaults.buttonColors(Color.Red),
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                viewModel.calcBmi()
                            }) {

                            Text(
                                text = "計算する",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold

                            )
                        }

                        Spacer(modifier = Modifier.height(40.dp))
                        /// 結果

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "あなたのBMIは${viewModel.resultBmi}",
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold

                        )


                    }
                }
            }
        }
    }

}

@Composable

fun TextField(
    value: String,
    callBack: (String) -> Unit,
    labelText: String,
    placeholder: String
) {
    Column() {
        Text(
            text = labelText,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = callBack,
            colors = TextFieldDefaults
                .textFieldColors(backgroundColor = Color.Transparent),
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true


        )
    }
}