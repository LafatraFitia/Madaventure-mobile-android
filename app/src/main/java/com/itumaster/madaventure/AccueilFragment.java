package com.itumaster.madaventure;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccueilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccueilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LoginFragment loginFragment;
    private ProfilFragment profilFragment;

    public AccueilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccueilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccueilFragment newInstance(String param1, String param2) {
        AccueilFragment fragment = new AccueilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private static final int[] imageResources = {
            R.drawable.baobab,
            R.drawable.antananarivo,
            R.drawable.baobab
    };

    private static final String[] imageCaptions = {
            "Image 1 Caption",
            "Image 2 Caption",
            "Image 3 Caption"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_accueil, container, false);

        LinearLayout imageContainer = rootView.findViewById(R.id.imageContainer);
        setupImageViews(imageContainer);

        loginFragment = new LoginFragment();
        profilFragment = new ProfilFragment();
        FloatingActionButton userBtn = rootView.findViewById(R.id.userbutton);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, profilFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    private void setupImageViews(LinearLayout parentLayout) {
        for (int i = 0; i < imageResources.length; i++) {
            CardView cardView = new CardView(requireContext());
            LinearLayout.LayoutParams cardLayoutParams = new LinearLayout.LayoutParams(
                    getResources().getDimensionPixelSize(R.dimen.card_width),
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            cardLayoutParams.setMargins(20, 0, 20, 0);
            cardView.setLayoutParams(cardLayoutParams);

            int cornerRadius = getResources().getDimensionPixelSize(R.dimen.card_corner_radius);
            Drawable backgroundDrawable = cardView.getBackground();
            if (backgroundDrawable instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) backgroundDrawable;
                gradientDrawable.setCornerRadius(cornerRadius);
            }

            LinearLayout verticalLayout = new LinearLayout(requireContext());
            verticalLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            verticalLayout.setOrientation(LinearLayout.VERTICAL);

            ImageButton imageButton = new ImageButton(requireContext());
            LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    getResources().getDimensionPixelSize(R.dimen.image_height));
            imageButton.setLayoutParams(imageLayoutParams);
            imageButton.setImageResource(imageResources[i]);
            int finalI = i;
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Rediriger vers le fragment détail en envoyant le nom de l'image
                    Bundle bundle = new Bundle();
                    bundle.putString("imageCaption", imageCaptions[finalI]);
                    // Utilisez votre code pour la redirection vers le fragment détail avec les arguments
                }
            });

            TextView captionTextView = new TextView(requireContext());
            LinearLayout.LayoutParams captionLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            captionLayoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            captionTextView.setLayoutParams(captionLayoutParams);
            captionTextView.setText(imageCaptions[i]);
            captionTextView.setTextColor(Color.BLACK);

            verticalLayout.addView(imageButton);
            verticalLayout.addView(captionTextView);
            cardView.addView(verticalLayout);
            parentLayout.addView(cardView);
        }
    }
}