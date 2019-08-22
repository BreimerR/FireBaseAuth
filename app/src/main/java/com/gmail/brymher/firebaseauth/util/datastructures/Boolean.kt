package com.gmail.brymher.firebaseauth.util.datastructures


fun Boolean.dO(action: () -> Unit) {
    if (this) {
        action()
    }
}