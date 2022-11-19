package com.example.jetprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetprofile.components.CompanySection
import com.example.jetprofile.components.DetailSection
import com.example.jetprofile.ui.theme.JetProfileTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      JetProfileTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          MainContent()
        }
      }
    }
  }

  @Composable
  fun MainContent() {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .padding(20.dp)
        .verticalScroll(rememberScrollState())
    ) {

      // プロフィール画像
      Image(
        painter = painterResource(
          id = R.drawable.image_profile
        ),
        contentDescription = "プロフィール",
        modifier = Modifier
          .size(100.dp)
          .clip(RoundedCornerShape(10.dp))
      )

      Spacer(modifier = Modifier.height(20.dp))

      // 氏名
      Text(
        text = "山田　太郎",
        color = Color.Gray,
        fontSize = 16.sp,
        fontWeight = FontWeight.ExtraBold
      )

      Spacer(modifier = Modifier.height(20.dp))

      // 職業
      Text(
        text = "職業: Androidエンジニア",
        color = Color.Gray,
      )

      Spacer(modifier = Modifier.height(20.dp))

      CompanySection()

      Spacer(modifier = Modifier.height(20.dp))

      // 詳細表示ボタン

      var isShowDetail by remember { mutableStateOf(false) }
      Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A)),
        onClick = { isShowDetail = !isShowDetail }
      ) {
        Text(
          text = "詳細を表示",
          color = Color.White
        )
      }

      Spacer(modifier = Modifier.height(20.dp))

      if (isShowDetail) DetailSection()

    }
  }

}