package com.example.ucp2roomdatabe.dependenciesinjection

import android.content.Context

interface InterfaceContainerApp {
    val repositoryDokter: RepositoryDokter
    val repositoryJadwal: RepositoryJadwal
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryDokter: RepositoryDokter by lazy {
        LocalRepositoryDokter(RSDatabase.getDatabase(context).dokterDao())
    }

    override val repositoryJadwal: RepositoryJadwal by lazy {
        LocalRepositoryJadwal(RSDatabase.getDatabase(context).jadwalDao())
    }
}