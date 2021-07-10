package models

data class Post (val postData: Int,
                 val postCategory: String,
                 val postTitle: String,
                 val postLike: Int,
                 val postComments: Int,
                 val postDescription: String,
                 val postPics: String?
                 )
