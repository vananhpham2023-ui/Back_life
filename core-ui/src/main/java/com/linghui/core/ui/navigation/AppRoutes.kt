package com.linghui.core.ui.navigation

object AppRoutes {
    const val HOME = "home"
    const val TASKS = "tasks"
    const val LOGS = "logs"
    const val ME = "me"

    const val ARG_TASK_ID = "taskId"
    const val TASK_DETAIL = "tasks/{$ARG_TASK_ID}"

    fun taskDetail(taskId: String): String = "tasks/$taskId"
}
