function bubbleSort(array) {
    var hasChanged = true;
    while (hasChanged) {
        hasChanged = false;
        for(var i = 0; i < array.length - 1; i++) {
            if(array[i] < array[i + 1]) {
                swap(array, i , i + 1);
                hasChanged = true;
            }
        }
    }
}

function swap(array, index1, index2) {
    var temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
}