package com.sss.mytestapp1.model.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sss.mytestapp1.R
import com.sss.mytestapp1.model.modelUser.User
import com.sss.mytestapp1.model.modelUser.UserItem

class UsersAdapter(private val interfaceForUsersAdapter: InterfaceForUsersAdapter) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var listUser = emptyList<UserItem>()

    class UsersViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_in_list,parent,false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        val textViewName = holder.itemView.findViewById<TextView>(R.id.id_item_user_in_list_tv_name)
        val textViewEmail = holder.itemView.findViewById<TextView>(R.id.id_item_user_in_list_tv_email)
        val textViewNumber = holder.itemView.findViewById<TextView>(R.id.id_item_user_in_list_tv_number)

        textViewName.text = listUser[position].name
        textViewEmail.text = listUser[position].email
        textViewNumber.text = "${position+1}"

    }

    override fun onViewAttachedToWindow(holder: UsersViewHolder) {
        super.onViewAttachedToWindow(holder)

        val cs = holder.itemView.findViewById<ConstraintLayout>(R.id.id_item_user_in_list_cs)

        cs.setOnClickListener {
            interfaceForUsersAdapter.showFullDescription(listUser[holder.adapterPosition])
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: User?){
        if(list != null){
            listUser = list
            notifyDataSetChanged()
        }
    }

}