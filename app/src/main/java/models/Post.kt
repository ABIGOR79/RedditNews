package models

data class Post (val postData: String,
                 val postCategory: String,
                 val postTitle: String,
                 val postLike: Int,
                 val postComments: Int,
                 val postDescription: String,
                 val postPics: String?
                 )
