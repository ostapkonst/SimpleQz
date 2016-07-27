package com.android.smplqz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ItemFragment extends Fragment {

    public static final String ARG_TEXT = "item_text";
    public static final String ARG_PSB_ANS = "item_psb_ans";
    public static final String ARG_ANS = "item_ans";
    public static final String ARG_POSITION = "item_position";
    public static final String ARG_COUNT = "item_count";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.pager_item, container, false);
        Bundle args = getArguments();

        ((TextView) rootView.findViewById(R.id.txtText)).setText(
                args.getString(ARG_TEXT));

        ((TextView) rootView.findViewById(R.id.txtCount)).setText(
                args.getInt(ARG_POSITION) + " / " + args.getInt(ARG_COUNT));

        String[] psbAns = args.getStringArray(ARG_PSB_ANS);
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.rdGroup);

        for (int i = 0; i < psbAns.length; i++) {
            RadioButton newButton = new RadioButton(rootView.getContext());

            newButton.setText(psbAns[i]);
            newButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            newButton.setId(i + 1);
            radioGroup.addView(newButton);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int ans = getArguments().getInt(ARG_ANS);
                int pos = getArguments().getInt(ARG_POSITION);
                QuizResult.setValue(pos - 1, ans, checkedId);
            }
        });

        return rootView;
    }
}