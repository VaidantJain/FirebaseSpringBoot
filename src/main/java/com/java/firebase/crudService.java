package com.java.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.protobuf.Api;
import io.opencensus.metrics.export.Summary;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class crudService {
    public String createCrud(crud crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user").document(crud.getId()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String updateCrud(crud crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("user").document(crud.getId()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteCrud(String id){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("user").document(id).delete();


        return "Successfully deleted" + id;
    }
    public crud getCrud(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("user").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        crud crud;
        if(document.exists()){
            crud = document.toObject(crud.class);
            return crud;
        }
        return null;
    }
}
