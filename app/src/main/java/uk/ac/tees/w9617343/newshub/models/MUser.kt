package uk.ac.tees.w9617343.newshub.models

data class MUser(
    val userId : String,
    val displayName:String,
    val avatarUrl:String,
    val quote:String,
    val profession:String,
    val id: String?
) {
    fun toMap():MutableMap<String,Any>{
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "avatar_url" to this.avatarUrl,
            "quote" to this.quote,
            "profession" to this.profession
        )
    }
}