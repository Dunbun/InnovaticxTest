package com.jetbrains;

class ListObject{
    int value;
    ListObject next;
    ListObject previous;

    public ListObject(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

public class MyList {
    private ListObject first;
    private ListObject last;
    private int listLength;

    public MyList(){
        first = null;
        last = null;
        listLength = 0;
    }

    public void addElement(int index, int value){
        ListObject newElement = new ListObject(value);
        index = getCorrectIndex(index, listLength);

        if(first == null) {
            first = newElement;
            last = newElement;
        }else {
            if(listLength == index || listLength == 0) {
                newElement.previous = last;
                last.next = newElement;
                last = newElement;
                last.next = first;
                first.previous = last;
            } else if(index == 0 ){
                first.previous = newElement;
                last.next = newElement;
                newElement.next = first;
                newElement.previous = last;
                first = newElement;
            }else if(listLength > index){
                ListObject tmpPtr = first;
                ListObject tmpPtrNext;

                tmpPtr = getNeededPtr(tmpPtr, index);
                tmpPtrNext = tmpPtr.next;
                tmpPtrNext.previous = newElement;
                tmpPtr.next = newElement;
                newElement.next = tmpPtrNext;
                newElement.previous = tmpPtr;
            }
        }
        listLength++;
    }

    public void deleteElement(int index){
        index = getCorrectIndex(index, listLength - 1);
        if(index != 0) {
            ListObject objPtr = getNeededPtr(first, index);
            ListObject objDelete = objPtr.next;
            ListObject objNextPtr = objDelete.next;
            objDelete = null;
            objPtr.next = objNextPtr;
            objNextPtr.previous = objPtr;
        }else{
             first = first.next;
             first.previous = last;
             last.next = first;
        }
        if(listLength == 1){
            first = null;
            last = null;
        }
        listLength--;
    }

    public void printMyList(){
        ListObject printObject = first;

        for(int i = 0; i < listLength; i++){
            System.out.println("index: " + i + ", value: " + printObject.value);
            printObject = printObject.next;
        }
    }

    public void reverse(MyList myList){
        int []array = new int[listLength];
        ListObject tmpObject = first;
        int tmpListLength = listLength;

        for(int i = 0; i < listLength; i++){
            array[i] = tmpObject.value;
            tmpObject = tmpObject.previous;
        }

        dropList(myList);
        for(int i = 0; i < tmpListLength; i++){
            myList.addElement(i,array[i]);
        }
    }

    private int getCorrectIndex(int index, int listLength){
        if(index > listLength){
            index = index % (listLength + 1);
        }else if(index == ((-listLength) - 1)){
            index = 0;
        }else if(index < 0){
            index = index * (-1);
            index = index % (listLength + 1);
            if(index == 0){
                return index;
            }
            index = listLength + 1 - index;
        }
        return index;
    }

    private ListObject getNeededPtr(ListObject listObject, int index){
        int indexCounter = 0;

        if(index != 0) {
            while (indexCounter != index - 1) {
                listObject = listObject.next;
                indexCounter++;
            }
        }else{
            listObject = first.previous;

        }
        return listObject;
    }

    private void dropList(MyList myList){
        int tmpListLength =listLength;

        for(int i = 0; i < tmpListLength; i++){
            myList.deleteElement(0);
        }
    }

}
