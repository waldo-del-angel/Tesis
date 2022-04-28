class CodigoBarrasFragment : Fragment(), CodigoBarrasView{

    private var codBarrasPresenter = CodigoBarrasPresenter(this, CodigoBarrasInteractor())
    private lateinit var barcodeview: DecoratedBarcodeView
    private lateinit var callback: BarcodeCallback
    private lateinit var beepManager : BeepManager

    override fun onCreateView(inflater: LayoutInflater,
    		container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_codigo_barras, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        codBarrasPresenter.iniciarBarcodeCallback()
        barcodeview = zxing_barcode_scanner as DecoratedBarcodeView
        callback = codBarrasPresenter.getBarcodeCallback()
        beepManager = BeepManager(activity)
        beepManager.apply {
            isBeepEnabled = true
            isVibrateEnabled = true
        }
        barcodeview?.decodeContinuous(callback)
    }

}
