package com.example.mvvmdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdesign.model.Blog
import com.example.mvvmdesign.model.viewModel.MainViewModel
import com.example.mvvmdesign.model.viewModel.MainViewModelFactory
//import java.util.Observer
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*


//class MainActivity : AppCompatActivity() {
//
//    private var viewManager = LinearLayoutManager(this)
//    private lateinit var viewModel:MainViewModel
//    private lateinit var mainRecycler: RecyclerView
//    private lateinit var btn: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        mainRecycler = findViewById(R.id.recycler)
//        val application  = requireNotNull(this).application
//        val factory = MainViewModelFactory()
//        btn = findViewById(R.id.button)
//
//        btn.setOnClickListener {
//
//            addData()
//        }
//        initializeAdapter()
//    }
//
//    private fun initializeAdapter() {
//        mainRecycler.layoutManager = viewManager
//        observeData()
//    }
//
////    fun observeData() {
////        viewModel.list.observe(this, Observer{
////            mainRecycler.adapter = NoteRecyclerAdapter(viewModel, )
////        })
////    }
//
////    private fun initialiseAdapter(){
////        mainRecycler.layoutManager = viewManager
////        observeData()
////    }
//
//    fun observeData(){
//        viewModel.list.observe(this, Observer{
//            Log.i("data",it.toString())
//            mainrecycler.adapter= NoteRecyclerAdapter(viewModel, it, this)
//        })
//
//        val blogObserver = Observer<String> {
//            mainRecycler.adapter = NoteRecyclerAdapter
//        }
//    }
//
//    fun addData() {
//        var txtplace = findViewById<EditText>(R.id.titletxt)
//        var title = txtplace.text.toString()
//        if(title.isNullOrBlank()) {
//            Toast.makeText(this, "Enter Value", Toast.LENGTH_LONG).show()
//        } else {
//            var blog = Blog(title)
//            viewModel.add(blog)
//            txtplace.text.clear()
//            mainRecycler.adapter?.notifyDataSetChanged()
//        }
//    }
//}

class MainActivity : AppCompatActivity() {
    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var mainrecycler: RecyclerView
    private lateinit var but: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainrecycler = findViewById(R.id.recycler)
        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel::class.java)
        but = findViewById(R.id.button)
        but.setOnClickListener {
            addData()
        }

        initialiseAdapter()
    }
    private fun initialiseAdapter(){
        mainrecycler.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        viewModel.getList().observe(this, Observer {
            Log.i("data", it.toString())

            mainrecycler.adapter = NoteRecyclerAdapter(viewModel, it as ArrayList<Blog>, this)
        })
    }


    fun addData(){
        var txtplce = findViewById<EditText>(R.id.titletxt)
        var title=txtplce.text.toString()
        if(title.isNullOrBlank()){
            Toast.makeText(this,"Enter value!",Toast.LENGTH_LONG).show()
        }else{
            var blog= Blog(title)
            viewModel.add(blog)
            txtplce.text.clear()
            mainrecycler.adapter?.notifyDataSetChanged()
        }

    }
}

