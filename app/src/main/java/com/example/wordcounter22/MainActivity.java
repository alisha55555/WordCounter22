package com.example.wordcounter22;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;  // Поле для ввода текста
    private TextView textViewResult; // Поле для вывода результата
    private Spinner spinnerCountOptions; // Спиннер для выбора "слова" или "символы"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов интерфейса
        editTextInput = findViewById(R.id.editTextText);
        textViewResult = findViewById(R.id.textView);
        spinnerCountOptions = findViewById(R.id.spinnerCountOptions);

        // Настройка Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountOptions.setAdapter(adapter);

        // Обработка нажатия кнопки
        Button buttonCount = findViewById(R.id.button2);
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем введенный текст
                String inputText = editTextInput.getText().toString();

                // Проверяем, что текст не пустой
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.error_empty_input), Toast.LENGTH_SHORT).show();
                    return;  // Если текст пустой, показываем Toast и прекращаем выполнение
                }

                // Создаем экземпляр класса WordCounter для выполнения подсчета
                WordCounter wordCounter = new WordCounter();
                // Получаем выбранную опцию из Spinner
                String selectedOption = spinnerCountOptions.getSelectedItem().toString();

                // В зависимости от выбранной опции подсчитываем слова или символы
                if (selectedOption.equals("Words")) {
                    int wordCount = wordCounter.countWords(inputText);
                    textViewResult.setText("Number of words: " + wordCount);
                } else {
                    int charCount = wordCounter.countChars(inputText);
                    textViewResult.setText("Number of symbols: " + charCount);
                }
            }
        });
    }
}
