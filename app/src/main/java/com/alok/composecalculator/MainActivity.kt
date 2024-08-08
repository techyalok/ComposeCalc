package com.alok.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alok.composecalculator.ui.theme.ComposeCalculatorTheme
import com.alok.composecalculator.ui.theme.LightGray
import com.alok.composecalculator.ui.theme.MediumGray
import com.alok.composecalculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                CalculatorApp (
                    onAction = viewModel::onAction,
                    state =  state,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MediumGray)
                        .padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun CalculatorApp(
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit,
    state: CalculatorState,
    buttonSpacing: Dp
){

    Box(modifier = modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
//1st Row
            // Comment
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(color = LightGray)
                        .weight(2f)
                        .aspectRatio(2f),
                    onClick = {onAction(CalculatorAction.Clear)}
                )

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(color = LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Delete)}
                )

                CalculatorButton(
                    symbol = "÷",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Operation(operation = CalculatorOperation.Divide))}
                )
            }
//2nd Row
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(7))}
                )

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(8))}
                )

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(9))}
                )

                CalculatorButton(
                    symbol = "×",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))}
                )
            }

//3rd Row
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(4))}
                )

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(5))}
                )

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(6))}
                )

                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))}
                )
            }

//4th Row
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(1))}
                )

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(2))}
                )

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Number(3))}
                )

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Operation(CalculatorOperation.Add))}
                )
            }

//5th Row
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {onAction(CalculatorAction.Number(0))}
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Decimal)}
                )

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(color = Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {onAction(CalculatorAction.Ans)}
                )
            }

        }
    }

}


@Preview()
@Composable
fun PreviewCal1(){
//    CalculatorApp {
//    }
}