package shop.sorayeon.android.bmi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Activity 가 생성될 때 Intent 에 담긴 값 추출
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height, weight : $weight")

        // BMI 계산
        // val bmi = weight / Math.pow(height / 100.0, 2.0)
        val bmi = weight / (height / 100.0).pow(2.0)

        // BMI 계산에 따른 결과
        // when {} 표현식 결과를 resultText 변수에 넣을 수 있다
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        // 출력할 TextView 생성
        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        // 결과 출력
        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}