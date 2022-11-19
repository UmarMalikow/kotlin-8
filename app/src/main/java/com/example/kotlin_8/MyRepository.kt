package com.example.kotlin_8

class MyRepository {

    private val listOfCharacters: ArrayList<MyModel> = ArrayList()

    fun getListOfPersons(): ArrayList<MyModel> {
        listOfCharacters.add(
            MyModel(
                "https://s-cdn.sportbox.ru/images/styles/500x280n/fp_fotos/15/a2/202a6d1ad98ad240f3f73326212670df625292ca73889682185309.jpg",
                "Дэн",21,"s"
            )
        )
        listOfCharacters.add(
            MyModel(
                "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcRn0JlWaneZ051s3Lsey2Abt0u64arT5CQgKa85FuIBbluDyKBZvIYpMtp6ucQvw0Qp4QXoG4g&s=19",
                "Спенсер", 12, "y"
            )
        )
        listOfCharacters.add(
            MyModel(
                "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcQRr_A05S911ER9cHRaEjeEk97XMkxLyPswUu9-PcWIqky_tOYY5ZXTpUvMuoI0JkBLCh7ZfUaB&s=19",
                "Крис",23,"e"
            )
        )
        listOfCharacters.add(
            MyModel(
                "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTD0dzoLpGxzBjvW0nrpk_gvkNZIO4FmR2zUqQwO0cmg0qZm66ZeGq1HHavnoUQUtVTkmuTzms&s=19",
                "Сара",34,"t"
            )
        )
        listOfCharacters.add(
            MyModel(
                "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTfM4KJSzP3OvobYq6RXKTeMz2guSj5YIS2Cxa6k4fplLormqTZ3DUKNQTcQ8X3NLs4U3p9kgw&s=19",
                "Кари",34,"s"
            )
        )
        listOfCharacters.add(
            MyModel(
                "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTG3V6OqamSipldcDRpggw5efmZs0op0EP9VQWzYuz1SJqsum4Rx0kgrhqEBQR-WofFH-XbQSSu&s=19",
                "Морис",56,"e"
            )
        )
        listOfCharacters.add(
            MyModel(
                "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcR8mKcy2WPG2qnQe0r0NgarWf_pYgC3HKiuK-1Izd1PnQXLno9pyn-yQjRBcVlQe_1JgekL68cy&s=19",
                "Томас",43,"a"
            )
        )
        return listOfCharacters
    }
}