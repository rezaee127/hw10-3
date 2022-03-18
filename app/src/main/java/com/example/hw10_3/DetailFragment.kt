package com.example.hw10_3


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.hw10_3.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate (inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayOfPictures= arrayOf(R.drawable.m1,R.drawable.m2,R.drawable.m3,
            R.drawable.m4,R.drawable.m5,R.drawable.m6)

        val arrayOfStrings= arrayOf(R.string.string1,R.string.string2,
            R.string.string3,R.string.string4,R.string.string5,R.string.string6)

        if(requireArguments().getInt("index")!=-1){
            val index=requireArguments().getInt("index")
            val title=requireArguments().getString("title")
            binding.imageView.setImageResource(arrayOfPictures[index])
            binding.textViewTitle.text=title
            binding.textViewDescription.setText(arrayOfStrings[index])
        }

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_share -> {
                share()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun share() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "${binding.textViewDescription.text}")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }





}