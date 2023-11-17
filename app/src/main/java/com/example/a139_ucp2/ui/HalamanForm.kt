package com.example.a139_ucp2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a139_ucp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClicked : (MutableList<String>) -> Unit,
    onBackButtonCLicked : () -> Unit,
    onSelectionChanged: (String) -> Unit,
    modifier: Modifier = Modifier
    DosenPembimbing: List<String>
){
    var namaTxt by remember {
        mutableStateOf("")
    }
    var NIMTxt by remember {
        mutableStateOf("")
    }
    var KonsentrasiTxt by remember {
        mutableStateOf("")
    }
    var JudulSkripsiTxt by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(namaTxt, NIMTxt, KonsentrasiTxt, JudulSkripsiTxt)
    var DosenPembimbing1 by remember{
        mutableStateOf("")
    }
    var DosenPembimbing2 by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulir Pengajuan Skripsi", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = namaTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.name)) },
                onValueChange = { namaTxt = it }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = NIMTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.nim)) },
                onValueChange = { NIMTxt = it }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = KonsentrasiTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.konsentrasi)) },
                onValueChange = { KonsentrasiTxt = it }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = JudulSkripsiTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.judul_Skripsi)) },
                onValueChange = { JudulSkripsiTxt = it }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            DosenPembimbing.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = DosenPembimbing1 == item,
                        onClick = {
                            DosenPembimbing2 = item
                            DosenPembimbing1 = item
                            onSelectionChanged(item)
                        }
                    )
                ) {
                    RadioButton(
                        selected = DosenPembimbing1 == item,
                        onClick = {
                            DosenPembimbing1 = item
                            onSelectionChanged(item)
                        })
                    RadioButton(
                        selected = DosenPembimbing2 == item,
                        onClick = {
                            DosenPembimbing2 = item
                            onSelectionChanged(item)
                        })
                }
            }
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(modifier = Modifier.weight(1f), onClick = {onSubmitButtonClicked(listData)}) {
                Text(text = stringResource(id = R.string.submit_button))
            }
        }
    }
}