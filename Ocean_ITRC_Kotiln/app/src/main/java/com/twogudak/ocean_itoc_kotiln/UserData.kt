package com.twogudak.ocean_itoc_kotiln

import android.content.Context
import android.content.SharedPreferences
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.userDTO
import com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager.UserInfoRespository


//사용자 정보 저장, 삭제

class UserData(context: Context) {
    var userinfoData = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE)
    var editor = userinfoData.edit()

    fun setuserinfo(UserDTO: userDTO): Boolean {
        editor.apply {
            putString(USER_ID, UserDTO.userId).apply()
            putString(USER_NAME, UserDTO.userName).apply()
            putString(USER_EMAIL, UserDTO.userEmail).apply()
            putString(USER_NAME_EN, UserDTO.userNameEN).apply()
            putString(USER_BELONG, UserDTO.userBelong).apply()
            putString(USER_DEPARTMENT, UserDTO.userDepartment).apply()
            putString(USER_POSITION, UserDTO.userPosition).apply()
            putString(USER_ADD, UserDTO.userAdd).apply()
            putString(USER_PHONE, UserDTO.userPhone).apply()
            putString(USER_IMAGE, UserDTO.userImg).apply()
            putString(TOKEN, UserDTO.Token).apply()
        }
        return editor.commit()
    }

    fun getUserInfo():HashMap<String, String>{
        return hashMapOf(
            USER_ID to userinfoData.getString(USER_ID, "")!!.toString(),
            USER_EMAIL to userinfoData.getString(USER_EMAIL, "")!!.toString(),
            USER_NAME to userinfoData.getString(USER_NAME, "")!!.toString(),
            USER_NAME_EN to userinfoData.getString(USER_NAME_EN, "")!!.toString(),
            USER_BELONG to userinfoData.getString(USER_BELONG, "")!!.toString(),
            USER_DEPARTMENT to userinfoData.getString(USER_DEPARTMENT, "")!!.toString(),
            USER_POSITION to userinfoData.getString(USER_POSITION, "")!!.toString(),
            USER_ADD to userinfoData.getString(USER_ADD, "")!!.toString(),
            USER_PHONE to userinfoData.getString(USER_PHONE, "")!!.toString(),
            USER_IMAGE to userinfoData.getString(USER_IMAGE, "")!!.toString(),
            TOKEN to userinfoData.getString(TOKEN, "")!!.toString(),
        )
    }

    fun removeUserInfo(){
        editor.clear().apply()
    }

    companion object{
        const val USER_ID = "USER_ID"
        const val USER_EMAIL = "USER_EMAIL"
        const val USER_NAME = "USER_NAME"
        const val USER_NAME_EN = "USER_NAME_EN"
        const val USER_BELONG = "USER_BELONG"
        const val USER_DEPARTMENT = "USER_DEPARTMENT"
        const val USER_POSITION = "USER_POSITION"
        const val USER_ADD = "USER_ADD"
        const val USER_PHONE = "USER_PHONE"
        const val USER_IMAGE = "USER_IMAGE"
        const val TOKEN = "TOKEN"
    }
}