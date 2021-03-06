package com.receipttracker.model

import android.graphics.Bitmap
import androidx.annotation.NonNull
import androidx.room.*
import com.google.gson.annotations.SerializedName
import org.json.JSONException
import org.json.JSONObject
import java.time.LocalDateTime
import retrofit2.Call


@Entity(
    tableName = "receipts"
  /*  indices = arrayOf(

        Index(
            value = ["user_id_for_receipt", "receipt_id"] // indexes these specific values so the db will query faster.
        )

    ),
    foreignKeys = arrayOf(
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("id"), // References id in user class. creates a relation between the id and userID value through use of a foreign key
            childColumns = arrayOf("user_id_for_receipt")
        )
    ) */
)
class SavedReceipt(

    @PrimaryKey(autoGenerate = true)//  @ColumnInfo(name = "receipt_id") @NonNull
    @SerializedName("id")
    var receiptId: Int? = null,

    val purchaseDate: String,


    val merchant: String,

    val amount: Float,

    val notes: String,

    val createdAt: String,

    val updatedAt: String,

    //@ColumnInfo(name = "user_id_for_receipt")
    @SerializedName("user_id")
    val userId : Int

   // val photo: Bitmap? = null

)
{
    companion object{
        val receiptList = mutableListOf<SavedReceipt>()
        const val TAG = "receipt string tag"
        const val NEW_ENTRY_REQUEST = 2
    }
}
//Receipt Media (Picture of the receipt). Has the same primarykey as saved receipt.
@Entity(
    tableName = "receipt_media"

   /* indices = arrayOf(
        Index(
            value = ["id", "receipt_id"]
        )
    ),
    foreignKeys = arrayOf (
        ForeignKey(
            entity = SavedReceipt::class,
            parentColumns = arrayOf("receipt_id"),
            childColumns = arrayOf("receipt_id")
        )
    ) */
)
class ReceiptMedia(

    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "receipt_id")
    var receiptId: Int,

    @ColumnInfo(name = "photo_url")
    var receiptPhotoUrl: String,

    @ColumnInfo(name = "description")
    var description: String
)

