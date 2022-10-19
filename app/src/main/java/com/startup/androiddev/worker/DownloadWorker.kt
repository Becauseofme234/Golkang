package com.startup.androiddev.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class DownloadWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {

        return try {
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}
