package com.android.smplqz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        List<Question> lstQstn = getData();
        QuizResult.setSize(lstQstn.size());

        TextPagerAdapter mTextPagerAdapter = new TextPagerAdapter(
                getSupportFragmentManager(), lstQstn);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mTextPagerAdapter);
        mViewPager.setOffscreenPageLimit(lstQstn.size());
    }

    public void toResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    // Требуется дописанть метод!
    private List<Question> getData() {
        List<Question> data = new ArrayList<>();
        data.add(new Question("Основная функция ЭВМ:", 3,
                "общение человека и машины",
                "разработка задач",
                "принцип программного управления"

        ));

        data.add(new Question("Микропроцессоры различаются между собой:", 4,
                "устройствами ввода и вывода",
                "счетчиками времени",
                "операционными системами времени",
                "разрядностью и тактовой частотой"
        ));

        data.add(new Question("Тактовая частота микропроцессора измеряется в:", 1,
                "мегагерцах",
                "кодах таблицы символов",
                "байтах и битах"
        ));

        data.add(new Question("От разрядности микропроцессора зависит:", 3,
                "количество используемых внешних устройств",
                "кодах таблицы символов",
                "максимальный объем внутренней памяти и производительность компьютера"
        ));

        data.add(new Question("Функции процессора состоят в:", 2,
                "подключении ЭВМ к электронной сети",
                "обработке данных, вводимых в ЭВМ"
        ));

        data.add(new Question("Постоянная память предназначена для:", 1,
                "длительного хранения информации",
                "хранения неизменяемой информации",
                "кратковременного хранения информации в текущий момент времени",
                "длительное хранение малого объема информации"
        ));

        data.add(new Question("Устройствами внешней памяти являются:", 1,
                "накопители на гибких магнитных дисках",
                "оперативные запоминающие устройства",
                "стриммеры",
                "плоттеры"
        ));

        data.add(new Question("Информация на магнитных дисках записывается:", 2,
                "в специальных магнитных окнах",
                "по концентрическим дорожкам и секторам",
                "по индексным отверстиям"
        ));

        data.add(new Question("Основная память содержит:", 1,
                "постоянное запоминающее устройство",
                "КЭШ-память",
                "кодовую шину инструкций (КШИ)",
                "порты ввода-вывода",
                "оперативное запоминающее устройство"
        ));

        data.add(new Question("При образовании имени файла можно использовать:", 1,
                "буквы латинского алфавита и цифры",
                "буквы русского алфавита",
                "цифры и специальные символы (>, <, =, пробел)"
        ));

        return data;
    }
}
