package lv.renarspikalovs.pd3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import lv.renarspikalovs.pd3.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
            Resources res = getResources();
            String [] themes = res.getStringArray(R.array.themes);
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String stuff= sharedPref.getString("Jusu_vards","");

        binding.buttonPref.setOnClickListener(v ->{
        switch (stuff) {
            case "":
                Toast.makeText(getActivity(), "Nothing found", Toast.LENGTH_LONG).show();
                break;
            default:
                binding.textviewSecond.setText(stuff);
                Toast.makeText(getActivity(), "Text is: " + stuff, Toast.LENGTH_LONG).show();
        }});

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}