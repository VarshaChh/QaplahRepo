package com.example.qaplah;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private ArFragment arFragment;
    private ModelRenderable bedRenderable,
                            chairRenderable,
                            interiorRenderable,
                            lampRenderable,
                            sofaRenderable,
                            designchairRenderable;

    ImageView bed,chair,interior,lamp,sofa,designchair;
    View[] arrayView;
    ViewRenderable name_furniture;

    int selected=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arFragment=(ArFragment)getSupportFragmentManager().findFragmentById(R.id.furniture_fragment);
        bed=(ImageView) findViewById(R.id.bed);
        chair=(ImageView) findViewById(R.id.dresser);
        interior=(ImageView) findViewById(R.id.interior);
        lamp=(ImageView) findViewById(R.id.Lamp);
        sofa=(ImageView)findViewById(R.id.sofa);
        designchair=(ImageView)findViewById(R.id.designerchair);


        setArrayView();
        setClickListener();
        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                if (selected == 1)
                {
                  Anchor anchor=hitResult.createAnchor();
                  AnchorNode anchorNode=new AnchorNode(anchor);
                  anchorNode.setParent(arFragment.getArSceneView().getScene());

                  createModel(anchorNode,selected);

                }
                if (selected == 2)
                {
                    Anchor anchor=hitResult.createAnchor();
                    AnchorNode anchorNode=new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);

                }
                if (selected == 3)
                {
                    Anchor anchor=hitResult.createAnchor();
                    AnchorNode anchorNode=new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);

                }
                if (selected == 4)
                {
                    Anchor anchor=hitResult.createAnchor();
                    AnchorNode anchorNode=new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);

                }
                if (selected == 5)
                {
                    Anchor anchor=hitResult.createAnchor();
                    AnchorNode anchorNode=new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);

                }
                if (selected == 6)
                {
                    Anchor anchor=hitResult.createAnchor();
                    AnchorNode anchorNode=new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel(anchorNode,selected);

                }


            }
        });
}

    private void setupModel() {
        /*ViewRenderable.builder()
                .setView(this,R.layout.name_furniture)
                .build()
                .thenAccept(renderable->name_furniture=renderable);*/

        ModelRenderable.builder().setSource(this, Uri.parse("bed.sfb"))
                .build().thenAccept(renderable->bedRenderable=renderable)
                .exceptionally(throwable ->{
                    Toast toast=
                    Toast.makeText(this,"Unable to load model",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                } );
        ModelRenderable.builder().setSource(this,Uri.parse("1.sfb"))
                .build().thenAccept(renderable->chairRenderable=renderable)
                .exceptionally(throwable ->{
                    Toast toast=
                            Toast.makeText(this,"Unable to load model",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;
                } );
        ModelRenderable.builder().setSource(this,Uri.parse("hustawka.sfb"))
                .build().thenAccept(renderable->interiorRenderable=renderable)
                .exceptionally(throwable ->{
                    Toast toast=
                            Toast.makeText(this,"Unable to load model",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;

                } );
        ModelRenderable.builder().setSource(this,Uri.parse("lamp.sfb"))
                .build().thenAccept(renderable->lampRenderable=renderable)
                .exceptionally(throwable ->{
                    Toast toast=
                            Toast.makeText(this,"Unable to load model",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;

                } );
        ModelRenderable.builder().setSource(this,Uri.parse("sofa.sfb"))
                .build().thenAccept(renderable->sofaRenderable=renderable)
                .exceptionally(throwable ->{
                    Toast toast=
                            Toast.makeText(this,"Unable to load model",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;

                } );
        ModelRenderable.builder().setSource(this,Uri.parse("designchair.sfb"))
                .build().thenAccept(renderable->designchairRenderable=renderable)
                .exceptionally(throwable ->{
                    Toast toast=
                            Toast.makeText(this,"Unable to load model",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    return null;

                } );




    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1)
        {
            TransformableNode furniture=new TransformableNode(arFragment.getTransformationSystem());
            furniture.setParent(anchorNode);
            furniture.setRenderable(bedRenderable);
            furniture.select();

            addName(anchorNode,furniture,"Bed");
        }
        else if (selected == 2)
        {
            TransformableNode furniture=new TransformableNode(arFragment.getTransformationSystem());
            furniture.setParent(anchorNode);
            furniture.setRenderable(chairRenderable);
            furniture.select();

            addName(anchorNode,furniture,"Chair");
        }
        else if (selected == 3)
        {
            TransformableNode furniture=new TransformableNode(arFragment.getTransformationSystem());
            furniture.setParent(anchorNode);
            furniture.setRenderable(interiorRenderable);
            furniture.select();

            addName(anchorNode,furniture,"Interior");
        }
        else if (selected == 4)
        {
            TransformableNode furniture=new TransformableNode(arFragment.getTransformationSystem());
            furniture.setParent(anchorNode);
            furniture.setRenderable(lampRenderable);
            furniture.select();

            addName(anchorNode,furniture,"Lamp");
        }
        else if (selected == 5)
        {
            TransformableNode furniture=new TransformableNode(arFragment.getTransformationSystem());
            furniture.setParent(anchorNode);
            furniture.setRenderable(sofaRenderable);
            furniture.select();

            addName(anchorNode,furniture,"Sofa");
        }
        else if (selected == 6)
        {
            TransformableNode furniture=new TransformableNode(arFragment.getTransformationSystem());
            furniture.setParent(anchorNode);
            furniture.setRenderable(designchairRenderable);
            furniture.select();

            addName(anchorNode,furniture,"Chair");
        }

    }
    private void addName(AnchorNode anchorNode,TransformableNode model, String name) {
        ViewRenderable.builder().setView(this, R.layout.name_furniture).build().thenAccept(viewRenderable -> {
            TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
            nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0));
            nameView.setParent(anchorNode);
            nameView.setRenderable(name_furniture);
            nameView.select();

            TextView txt_name = (TextView) name_furniture.getView();
            txt_name.setText(name);
            txt_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    anchorNode.setParent(null);
                }
            });
        });
    }

    private void setClickListener(){
        for(int i=0;i<arrayView.length;i++)
            arrayView[i].setOnClickListener(this);
    }

    private void setArrayView() {
        arrayView=new View[]{
                bed,chair,interior,lamp,sofa,designchair
        };
    }




    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bed)
        {
            selected = 1;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.dresser)
        {
            selected=2;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.interior)
        {
            selected=3;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.Lamp)
        {
            selected=4;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.sofa)
        {
            selected=5;
            setBackground(v.getId());
        }
        else if(v.getId() == R.id.designerchair)
        {
            selected=6;
            setBackground(v.getId());
        }


    }

    private void setBackground(int id) {
        for(int i=0;i<arrayView.length;i++)
        {
            if (arrayView[i].getId()==id)
            {
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            }
            else
            {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}








