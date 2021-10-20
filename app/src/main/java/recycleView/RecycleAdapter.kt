package recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappapi.R
import models.Post

class RecycleAdapter(private val postList: List<Post>):
    RecyclerView.Adapter<RecycleAdapter.PostNewsHolder>(){

    class PostNewsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var postCategory: TextView? = null
        var postTime: TextView? = null
        var postTitle: TextView? = null
        var postLike: TextView? = null
        var postDescription: TextView? = null
        var postPicture: ImageView? = null
        var postComments: TextView? = null

        init {
            postCategory = itemView.findViewById(R.id.categoryPost)
            postTime = itemView.findViewById(R.id.dataPost)
            postTitle = itemView.findViewById(R.id.titlePost)
            postLike = itemView.findViewById(R.id.likePost)
            postDescription = itemView.findViewById(R.id.descriptionPost)
            postPicture = itemView.findViewById(R.id.imagePost)
            postComments = itemView.findViewById(R.id.commentsPost)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostNewsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleview_list, parent, false)
        return PostNewsHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostNewsHolder, position: Int) {
        holder.postCategory?.text = postList[position].postCategory
        holder.postTime?.text = postList[position].postData
        holder.postTitle?.text = postList[position].postTitle
        holder.postLike?.text = postList[position].postLike.toString()
        holder.postDescription?.text = postList[position].postDescription
        holder.postPicture?.let {
            Glide.with(holder.itemView.context)
                .load(postList[position].postPics)
                .centerCrop()
                .into(it)
        }
        holder.postComments?.text = String.format(holder.itemView.context.getString(R.string.comments), postList[position].postComments.toString())

        }

    override fun getItemCount(): Int {
        return postList.size
    }

}