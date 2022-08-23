package com.arash.altafi.coroutine.sample0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.coroutine.databinding.ActivitySample0Binding
import com.arash.altafi.coroutine.sample0.coroutineflow.CoroutineFlowActivity
import com.arash.altafi.coroutine.sample0.coroutinejob.CoroutineJobActivity
import com.arash.altafi.coroutine.sample0.gettingstarted.GettingStartedActivity
import com.arash.altafi.coroutine.sample0.jobtimeout.JobTimeOutActivity
import com.arash.altafi.coroutine.sample0.lifecyclescope.LifecycleScopeActivity
import com.arash.altafi.coroutine.sample0.livedatascope.LiveDataScopeActivity
import com.arash.altafi.coroutine.sample0.localcall.RoomBasicActivity
import com.arash.altafi.coroutine.sample0.networkcall.ParallelNetworkCallActivity
import com.arash.altafi.coroutine.sample0.networkcall.SequentialNetworkCallActivity
import com.arash.altafi.coroutine.sample0.networkcall.SingleNetworkCallActivity
import com.arash.altafi.coroutine.sample0.networkcall.SingleNetworkCallWithImagesActivity
import com.arash.altafi.coroutine.sample0.sequentialparalleltask.SequentialParallelTaskActivity
import com.arash.altafi.coroutine.sample0.utils.openActivity
import com.arash.altafi.coroutine.sample0.viewmodelscope.ViewModelScopeActivity

class SampleActivity0 : AppCompatActivity() {

    private lateinit var binding: ActivitySample0Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        binding.gettingStated.setOnClickListener {
            openActivity(GettingStartedActivity::class.java)
        }

        binding.jobTimeOut.setOnClickListener {
            openActivity(JobTimeOutActivity::class.java)
        }

        binding.coroutineJob.setOnClickListener {
            openActivity(CoroutineJobActivity::class.java)
        }

        binding.sequentialParallel.setOnClickListener {
            openActivity(SequentialParallelTaskActivity::class.java)
        }

        binding.coroutineFlow.setOnClickListener {
            openActivity(CoroutineFlowActivity::class.java)
        }

        binding.lifecycleScope.setOnClickListener {
            openActivity(LifecycleScopeActivity::class.java)
        }

        binding.viewModelScope.setOnClickListener {
            openActivity(ViewModelScopeActivity::class.java)
        }

        binding.liveDataScope.setOnClickListener {
            openActivity(LiveDataScopeActivity::class.java)
        }

        binding.singleNetworkCall.setOnClickListener {
            openActivity(SingleNetworkCallActivity::class.java)
        }

        binding.parallelNetworkCall.setOnClickListener {
            openActivity(ParallelNetworkCallActivity::class.java)
        }

        binding.sequentialNetworkCall.setOnClickListener {
            openActivity(SequentialNetworkCallActivity::class.java)
        }

        binding.singleNetworkCallWithImages.setOnClickListener {
            openActivity(SingleNetworkCallWithImagesActivity::class.java)
        }

        binding.roomBasic.setOnClickListener {
            openActivity(RoomBasicActivity::class.java)
        }
    }

}