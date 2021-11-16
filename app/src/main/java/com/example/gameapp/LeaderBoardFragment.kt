package com.example.gameapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class LeaderBoardFragment : Fragment(R.layout.fragment_leader_board)
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_leader_board, container, false)

        val viewAdapter = MyAdapter(arrayOf("Flo", "Ly", "Jo", "Charley", "Rex", "Marianne", "Hannah", "Brit"))

        view.findViewById<RecyclerView>(R.id.leaderboard_list).run {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
        return view
    }
}

class MyAdapter(val data: Array<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(val item: View): RecyclerView.ViewHolder(item){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)


        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.item.findViewById<TextView>(R.id.list_user_name).text = data[position]


        holder.item.setOnClickListener {
            val name = data[position]
            val action = LeaderBoardFragmentDirections.actionLeaderBoardFragmentToProfileFragment(name)
            holder.item.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
