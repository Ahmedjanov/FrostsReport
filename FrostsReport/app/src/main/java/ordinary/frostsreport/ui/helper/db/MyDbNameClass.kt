package ordinary.frostsreport.ui.helper.db

import android.provider.BaseColumns

object MyDbNameClass {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "FrostsReport.db"

/************************** TABLE CLIENT **********************/

    object Client : BaseColumns {
        const val TABLE_NAME_CLIENT = "client"
        const val COLUMN_NAME_CLIENT_NAME = "client_name"
    }

    const val SQL_CREATE_CLIENT =
        "CREATE TABLE IF NOT EXISTS ${Client.TABLE_NAME_CLIENT} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${Client.COLUMN_NAME_CLIENT_NAME} TEXT)"

    const val SQL_DELETE_CLIENT = "DROP TABLE IF EXISTS ${Client.TABLE_NAME_CLIENT}"

////////////////////////////////////////////////////////////////

/*************************** TABLE PRODUCT *********************/

    object Product : BaseColumns {
        const val TABLE_NAME_PRODUCT = "product"
        const val COLUMN_NAME_PRODUCT_NAME = "product_name"
        const val COLUMN_NAME_PRODUCT_PRICE = "product_price"
    }

    const val SQL_CREATE_PRODUCT =
        "CREATE TABLE IF NOT EXISTS ${Product.TABLE_NAME_PRODUCT} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${Product.COLUMN_NAME_PRODUCT_NAME} TEXT," +
                "${Product.COLUMN_NAME_PRODUCT_PRICE} REAL)"

    const val SQL_DELETE_PRODUCT = "DROP TABLE IF EXISTS ${Product.TABLE_NAME_PRODUCT}"

//////////////////////////////////////////////////////////////////
}