package shop.sorayeon.android.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 신장
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        // 체중
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        // 계산하기 버튼
        val resultButton = findViewById<Button>(R.id.resultButton)

        // 계산하기버튼 클릭 이벤트
        resultButton.setOnClickListener {
            // 유효성 검사
            // 신장 혹은 체중중 입력이 안되있으면 Toast 메세지
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 이 아래로는 절대 빈 값이 올 수 없음.
            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            Log.d("MainActivity", "height : $height, weight : $weight")

            // 다른 엑티비티를 만들면 Manifest.xml 파일에 Activity 추가
            val intent = Intent(this, ResultActivity::class.java)
            // 다른 엑티비티로 데이터 넘기는 방법
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            // 인텐트 생성후 startActivity() 호출
            startActivity(intent)
        }
    }
}